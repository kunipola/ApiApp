package jp.techacademy.yoshihiro.kunieda.apiapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import jp.techacademy.yoshihiro.kunieda.apiapp.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.loadUrl(intent.getStringExtra(KEY_URL).toString())

        binding.favoriteImageView2.apply {
            intent.getStringExtra("ID")

            // お気に入り状態を取得
            val isFavorite2 = FavoriteShop.findBy("ID")

            if (isFavorite2 != null) {
                R.drawable.ic_star // 白塗りの星を設定
            } else{
                R.drawable.ic_star_border // 白抜きの星を設定
            }

            // 星をタップした時の処理
            setOnClickListener{
                if (isFavorite2 != null){
                    R.drawable.ic_star_border // 白抜きの星を設定
                }else{
                    R.drawable.ic_star // 白塗りの星を設定
                }
            }
        }
    }

    companion object {
        private const val KEY_URL = "key_url"
        fun start(activity: Activity, url: String) {
            activity.startActivity(
                Intent(activity, WebViewActivity::class.java).putExtra(
                    KEY_URL,
                    url
                )
            )
        }
    }



}