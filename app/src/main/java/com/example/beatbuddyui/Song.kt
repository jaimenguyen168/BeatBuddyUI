package com.example.beatbuddyui

data class Song(
    val id: Long,
    val title: String,
    val link: String,
    val duration: Int,
    val preview: String,
    val artist: String,
    val artistPicture: String,
    val album: String,
    val albumCover: String
)

object MockData {
    val songs = mutableListOf(
        Song(
            id = 2614318122,
            title = "yes, and?",
            link = "https://www.deezer.com/track/2614318122",
            duration = 215,
            preview = "https://cdns-preview-3.dzcdn.net/stream/c-3aea14414dbd4dfa62116639126d27c9-2.mp3",
            artist = "Ariana Grande",
            artistPicture = "https://api.deezer.com/artist/1562681/image",
            album = "Eternal Sunshine",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/eca6766746c9ad358c208df95fc3ec2c/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2440763155,
            title = "vampire",
            link = "https://www.deezer.com/track/2440763155",
            duration = 220,
            preview = "https://cdns-preview-a.dzcdn.net/stream/c-a863d6067b14e05905548682f3d16993-2.mp3",
            artist = "Olivia Rodrigo",
            artistPicture = "https://api.deezer.com/artist/11152580/image",
            album = "GUTS",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/4bb79214365c0049e031f5e2caae4752/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2414222995,
            title = "Gimme Love",
            link = "https://www.deezer.com/track/2414222995",
            duration = 177,
            preview = "https://cdns-preview-b.dzcdn.net/stream/c-ba6d68d0e94dfc16c41eefc855e4f422-3.mp3",
            artist = "Sia",
            artistPicture = "https://api.deezer.com/artist/3469/image",
            album = "Gimme Love",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/0c573e0512a66c2029adfa8bc492da80/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2366043655,
            title = "What Was I Made For? [From The Motion Picture \"Barbie\"]",
            link = "https://www.deezer.com/track/2366043655",
            duration = 222,
            preview = "https://cdns-preview-8.dzcdn.net/stream/c-840d9d9b9875e413cf5c00a5d6918626-6.mp3",
            artist = "Billie Eilish",
            artistPicture = "https://api.deezer.com/artist/9635624/image",
            album = "What Was I Made For? [From The Motion Picture \"Barbie\"]",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/2562b8d68b75635bb2d4b92dc7ed9ab5/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 1703487577,
            title = "As It Was",
            link = "https://www.deezer.com/track/1703487577",
            duration = 167,
            preview = "https://cdns-preview-a.dzcdn.net/stream/c-a8a467c31d47cccd3524d35fe3452e9b-3.mp3",
            artist = "Harry Styles",
            artistPicture = "https://www.deezer.com/artist/5313805",
            album = "As It Was",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/b0e936124f59e669ddba02ebe5893f95/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2444176345,
            title = "greedy",
            link = "https://www.deezer.com/track/2444176345",
            duration = 131,
            preview = "https://cdns-preview-d.dzcdn.net/stream/c-d3798b1f541af7a8886af7e8fec035b9-2.mp3",
            artist = "Tate McRae",
            artistPicture = "https://api.deezer.com/artist/13817211/image",
            album = "greedy",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/ef25b6bec265332a059879f45d33cd7e/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2614318122,
            title = "yes, and?",
            link = "https://www.deezer.com/track/2614318122",
            duration = 215,
            preview = "https://cdns-preview-3.dzcdn.net/stream/c-3aea14414dbd4dfa62116639126d27c9-2.mp3",
            artist = "Ariana Grande",
            artistPicture = "https://api.deezer.com/artist/1562681/image",
            album = "Eternal Sunshine",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/eca6766746c9ad358c208df95fc3ec2c/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2440763155,
            title = "vampire",
            link = "https://www.deezer.com/track/2440763155",
            duration = 220,
            preview = "https://cdns-preview-a.dzcdn.net/stream/c-a863d6067b14e05905548682f3d16993-2.mp3",
            artist = "Olivia Rodrigo",
            artistPicture = "https://api.deezer.com/artist/11152580/image",
            album = "GUTS",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/4bb79214365c0049e031f5e2caae4752/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2414222995,
            title = "Gimme Love",
            link = "https://www.deezer.com/track/2414222995",
            duration = 177,
            preview = "https://cdns-preview-b.dzcdn.net/stream/c-ba6d68d0e94dfc16c41eefc855e4f422-3.mp3",
            artist = "Sia",
            artistPicture = "https://api.deezer.com/artist/3469/image",
            album = "Gimme Love",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/0c573e0512a66c2029adfa8bc492da80/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2366043655,
            title = "What Was I Made For? [From The Motion Picture \"Barbie\"]",
            link = "https://www.deezer.com/track/2366043655",
            duration = 222,
            preview = "https://cdns-preview-8.dzcdn.net/stream/c-840d9d9b9875e413cf5c00a5d6918626-6.mp3",
            artist = "Billie Eilish",
            artistPicture = "https://api.deezer.com/artist/9635624/image",
            album = "What Was I Made For? [From The Motion Picture \"Barbie\"]",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/2562b8d68b75635bb2d4b92dc7ed9ab5/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 1703487577,
            title = "As It Was",
            link = "https://www.deezer.com/track/1703487577",
            duration = 167,
            preview = "https://cdns-preview-a.dzcdn.net/stream/c-a8a467c31d47cccd3524d35fe3452e9b-3.mp3",
            artist = "Harry Styles",
            artistPicture = "https://www.deezer.com/artist/5313805",
            album = "As It Was",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/b0e936124f59e669ddba02ebe5893f95/500x500-000000-80-0-0.jpg"
        ),
        Song(
            id = 2444176345,
            title = "greedy",
            link = "https://www.deezer.com/track/2444176345",
            duration = 131,
            preview = "https://cdns-preview-d.dzcdn.net/stream/c-d3798b1f541af7a8886af7e8fec035b9-2.mp3",
            artist = "Tate McRae",
            artistPicture = "https://api.deezer.com/artist/13817211/image",
            album = "greedy",
            albumCover = "https://e-cdns-images.dzcdn.net/images/cover/ef25b6bec265332a059879f45d33cd7e/500x500-000000-80-0-0.jpg"
        )
    )
}