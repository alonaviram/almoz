package com.pere.user.almoznino

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity(), View.OnClickListener
    , MediaPlayer.OnPreparedListener {

    private lateinit var media: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        media = MediaPlayer()
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val img : ImageView = findViewById(R.id.imageView)
        img.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (media.isPlaying) {
                media.stop()
                media.reset()
            } else {
                media.reset()
            }
            val asf =
                when (v.id) {
                    R.id.btn1 ->
                        resources.openRawResourceFd(R.raw.hod)

                    R.id.btn2 ->
                        resources.openRawResourceFd(R.raw.kama)

                    R.id.btn3 ->
                        resources.openRawResourceFd(R.raw.ma)

                    R.id.btn4 ->
                        resources.openRawResourceFd(R.raw.mispar)

                    R.id.btn5 ->
                        resources.openRawResourceFd(R.raw.osul)

                    R.id.btn6 ->
                        resources.openRawResourceFd(R.raw.psshh)

                    R.id.btn7 ->
                        resources.openRawResourceFd(R.raw.walla)

                    R.id.btn8 ->
                        resources.openRawResourceFd(R.raw.walla2)

                    R.id.btn9 ->
                        resources.openRawResourceFd(R.raw.walla3)

                    R.id.imageView ->
                        resources.openRawResourceFd(R.raw.whistle)

                    else ->
                        resources.openRawResourceFd(R.raw.whistle)
                }
            try {
                media.setDataSource(asf.fileDescriptor, asf.startOffset, asf.length)
                media.setOnPreparedListener(this)
                media.prepareAsync()
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    override fun onPrepared(mp: MediaPlayer?) {
        media.start()
    }
}
