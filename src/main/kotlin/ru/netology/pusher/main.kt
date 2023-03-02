package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "SkillBox",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()
    FirebaseMessaging.getInstance().send(message)

//    val messageNewPost = Message.builder()
//        .putData("action", "NEWPOST")
//        .putData("content", """{
//          "userName": "Ленин В.И.",
//          "content": "Товарищи красноармейцы! Капиталисты Англии, Америки, Франции ведут войну против России. Они мстят Советской рабочей и крестьянской республике за то, что она свергла власть помещиков и капиталистов и дала тем пример для всех народов земли. Капиталисты Англии, Франции и Америки помогают деньгами и военными припасами русским помещикам, которые ведут против Советской власти войска из Сибири, Дона, Северного Кавказа, желая восстановить власть царя, власть помещиков, власть капиталистов. Нет. Этому не бывать!"
//        }""".trimIndent())
//        .setToken(token)
//        .build()
//    FirebaseMessaging.getInstance().send(messageNewPost)

//    val messageUnknown = Message.builder()
//        .putData("action", "ERROR")
//        .putData("content", """{
//          "userName": "Alexandro",
//          "content": "u shouldn't see it in notification"
//        }""".trimIndent())
//        .setToken(token)
//        .build()
//    FirebaseMessaging.getInstance().send(messageUnknown)

    print("Work done, Sir!")
}
