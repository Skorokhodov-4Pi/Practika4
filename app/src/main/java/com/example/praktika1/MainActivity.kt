package com.example.praktika1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.praktika1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val post = Post(
            id = 1,
            author = "Борисоглебский техникум промышленных и информационных техологий",
            content = "ГБПОУ ВО «БТПИТ» образовано в соответствии с постановлением правительства Воронежской области от 20 мая 2015 года № 401 в результате реорганизации в форме слияния ГОБУ СПО ВО «БИТ», ГОБУ СПО ВО «БТИВТ» и ГОБУ НПО ВО «ПУ № 34 г. Борисоглебска»\nОбразовательно-производственный центр (кластер) федерального проекта\n\"Профессионалитет\" по отраслям «Туризм и сфера услуг» на базе ГБПОУ ВО \"ХШН\" и «Педагогика» на базе ГБПОУ ВО \"ГПК\" .\nКолледжи-партнеры: Базовая ОО - ГБПОУ ВО \"ХШН\"; сетевые ОО - ГБПОУ ВО \"БАИК\", ГБПОУ ВО \"ВГПГК\", ГБПОУ ВО \"ВТППП\", ГБПОУ ВО \"ВГПТК\", ГБПОУ ВО \"БТПИТ\".\nКолледжи-партнеры: Базовая ОО - ГБПОУ ВО \"ГПК\"; сетевые ОО - ГБПОУ ВО \"ВГПГК имени В.М. Пескова“, ГБПОУ ВО \"БТПИТ\".\nПодробнее о федеральном проекте «Профессионалитет» на сайте",
            published = "18 марта в 11:21",
            likes = 999999,
            share = 990,
            likedByMe = false
        )
        with(binding){
            author.text = post.author
            published.text = post.published
            mainText.text = post.content
            textView5.text = post.likes.toString()
            textView6.text = post.share.toString()
            if (post.likedByMe) {
                imageButton7?.setImageResource(R.drawable.like_placeholder_svgrepo_com)
            }
            imageButton8?.setOnClickListener {
                post.share++
                textView6.text = post.share.toString()
                when {
                    post.share<1000 ->textView6.text =post.share.toString()
                    post.share in 1000..999999 ->textView6.text ="${post.share/1000}K"
                    else->textView6.text =String.format("%.1fM",post.share.toDouble()/1000000)
                }

            }

            imageButton7?.setOnClickListener {
                post.likedByMe = !post.likedByMe
                imageButton7.setImageResource(
                    if (post.likedByMe) R.drawable.like_svgrepo_com__1_
                    else R.drawable.like_placeholder_svgrepo_com
                )
                if (post.likedByMe) post.likes++ else post.likes--
                textView5.text = post.likes.toString()
                when {
                    post.likes in 1000..999999 ->textView5.text ="${post.likes/1000}K"
                    post.likes<1000->textView5.text =post.likes.toString()
                    else->textView5.text =String.format("%.1fM",post.likes.toDouble()/1000000)
                }
            }
        }
    }

    data class Post(
        val id: Int,
        val author: String,
        val content: String,
        val published: String,
        var likes: Int,
        var share: Int,
        var likedByMe: Boolean = false
    )
}

