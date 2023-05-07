import 'package:audio_service/audio_service.dart';
import 'package:flutter/material.dart';
import 'package:just_audio_background/just_audio_background.dart';
import 'package:music_player/components/music_player_theme.dart';
import 'package:music_player/screens/home.dart';

void main() async {
  await JustAudioBackground.init(
    androidNotificationChannelId: 'com.ryanheise.bg_demo.channel.audio',
    androidNotificationChannelName: 'Audio playback',
    androidNotificationOngoing: true,
  );
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Melodify',
      theme: ThemeData(
          appBarTheme: AppBarTheme(
              backgroundColor: MusicPlayerTheme().primaryAppBarColor)),
      debugShowCheckedModeBanner: false,
      home: const Home(),
    );
  }
}
