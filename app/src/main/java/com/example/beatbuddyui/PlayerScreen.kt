package com.example.beatbuddyui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.beatbuddyui.MockData.songs

@Composable
fun PlayerScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
        ) {
            items(songs.size) { index ->
                MusicItem(
                    onClick = {},
                    song = songs[index]
                )
            }
        }
    }
}

@Composable
fun MusicItem(
    song: Song,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(song.albumCover)
            .size(Size.ORIGINAL)
            .build()
    ).state

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onClick() },
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LazyRow {
            items(Genre.entries.size) { index ->
                Text(
                    text = Genre.entries[index].title
                )
            }
        }

        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(48.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentAlignment = Alignment.Center
            ) {
                if (imageState.painter != null) {
                    Image(
                        painter = imageState.painter!!,
                        contentDescription = song.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(56.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )
                } else {
                    Icon(
                        modifier = Modifier.size(56.dp),
                        imageVector = Icons.Rounded.ImageNotSupported,
                        contentDescription = "\"${song.title}\" track cover"
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(300.dp)
                    .padding(bottom = 4.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = song.title,
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = song.artist,
                    maxLines = 1,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MusicItemPV() {
//    MusicItem(
//        song = MockData.songs[0],
//        onClick = {}
//    )
    PlayerScreen()
}