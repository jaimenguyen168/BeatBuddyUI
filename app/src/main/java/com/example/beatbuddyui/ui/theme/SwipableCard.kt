package com.example.beatbuddyui.ui.theme

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.beatbuddyui.CardItem
import com.example.beatbuddyui.Song
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.roundToInt

@SuppressLint("MutableCollectionMutableState")
@Composable
fun SwipeableCard(
    songs: MutableList<Song>
) {
    val visibleCard: Int = StrictMath.min(3, songs.size)
    val scope = rememberCoroutineScope()
    val offset: Animatable<Offset, AnimationVector2D> = remember {
        Animatable(
            Offset(0f, 0f),
            Offset.VectorConverter
        )
    }
    val animationSpec: FiniteAnimationSpec<Offset> = tween(
        durationMillis = 150,
        easing = LinearEasing
    )

    val songList = remember { mutableStateOf(songs) }

    fun rearrangeForward() {
        if (songs.isNotEmpty()) {
            songs.removeAt(0)
            songList.value = songs.toMutableList()
        }
    }

    val dummyState = remember { mutableStateOf(true) }

    LaunchedEffect(songList.value) {
        dummyState.value = !dummyState.value
    }

    Box(
        Modifier.fillMaxWidth()) {

        repeat(visibleCard) { index ->
            val zIndex = 100f - index
            val scale = calculateScale(index)
            val offsetY = calculateOffset(index)
            val cardModifier =
                makeCardModifier(
                    scope = scope,
                    cardIndex = index,
                    scale = scale,
                    zIndex = zIndex,
                    offsetY = offsetY,
                    offset = offset,
                    rearrangeForward = { rearrangeForward() },
                    rearrangeBackward = { rearrangeForward() },
                    animationSpec = animationSpec
                )

            CardItem(
                modifier = cardModifier,
                song = songList.value[index]
            )
        }
    }
}

@SuppressLint("ModifierFactoryExtensionFunction")
fun makeCardModifier(
    scope: CoroutineScope,
    cardIndex: Int,
    scale: Float,
    zIndex: Float,
    offset: Animatable<Offset, AnimationVector2D>,
    animationSpec: FiniteAnimationSpec<Offset>,
    offsetY: Int,
    rearrangeForward: () -> Unit,
    rearrangeBackward: () -> Unit
): Modifier {
    return if (cardIndex > 0) Modifier
        .graphicsLayer {
            translationY =
                if (offset.value.y != 0f) min(
                    abs(offset.value.y),
                    110f * 1.1f
                ) else 0f
            scaleX = if (offset.value.y != 0f) {
                min(scale + (abs(offset.value.y) / 1000), 1.06f - (cardIndex * 0.03f))
            } else scale
            scaleY = if (offset.value.y != 0f) {
                min(scale + (abs(offset.value.y) / 1000), 1.06f - (cardIndex * 0.03f))
            } else scale
        }
        .scale(scale)
        .offset { IntOffset(0, offsetY) }
        .zIndex(zIndex)
        .fillMaxWidth()
        .height(430.dp)
    else Modifier
        .scale(scale)
        .offset { IntOffset(offset.value.x.roundToInt(), offset.value.y.roundToInt()) }
        .zIndex(zIndex)
        .fillMaxWidth()
        .height(430.dp)
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = {
                    scope.launch {
                        rearrangeBackward()
                        offset.animateTo(
                            targetValue = Offset(-600f, 600f),
                            animationSpec = snap()
                        )
                        offset.animateTo(
                            targetValue = Offset(0f, 0f),
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = LinearEasing
                            )
                        )
                    }
                }
            )
        }
        .pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                val dragOffset = Offset(
                    offset.value.x + change.positionChange().x,
                    offset.value.y + change.positionChange().y
                )
                scope.launch {
                    offset.snapTo(dragOffset)
                    change.consumePositionChange()
                    val x = when {

                        offset.value.x > 250 -> size.width.toFloat()
                        offset.value.x < -250 -> -size.width.toFloat()
                        else -> 0f
                    }
                    val y = when {

                        offset.value.y > 250 -> size.height.toFloat()
                        offset.value.y < -250 -> -size.height.toFloat()
                        else -> 0f
                    }

                    offset.animateTo(
                        targetValue = Offset(x, y),
                        animationSpec = animationSpec
                    )
                    if (abs(offset.value.x) == size.width.toFloat() || abs(offset.value.y) == size.height.toFloat()) {
                        rearrangeForward()
                        offset.animateTo(
                            targetValue = Offset(0f, 0f),
                            animationSpec = snap()
                        )
                    }
                }
            }
        }
}

private fun calculateScale(idx: Int): Float {
    return when (idx) {
        1 -> 0.97f
        2 -> 0.94f
        else -> 1f
    }
}

private fun calculateOffset(idx: Int): Int {
    return when (idx) {
        1 -> -(110f * idx * 1.1).toInt()
        2 -> -(110f * idx * 1.1).toInt()
        else -> (-110f).toInt()
    }
}