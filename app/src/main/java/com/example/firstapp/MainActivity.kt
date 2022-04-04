package com.example.firstapp

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {
    private lateinit var camera: CameraManager;
    private lateinit var button: ImageButton;
    var isFlash = false

    private lateinit var reaa: RelativeLayout
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        val actionBar = supportActionBar
        actionBar!!.setHomeButtonEnabled(false)
        actionBar.hide();

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.torch);
        camera = getSystemService(Context.CAMERA_SERVICE) as CameraManager;
        reaa = findViewById(R.id.reala);
        button.setOnClickListener { flashlighonoff(it) }
    }
        @RequiresApi(Build.VERSION_CODES.M)
        private fun flashlighonoff(it: View?) {
            if (!isFlash) {
                val cameralist = camera.cameraIdList[0]
                camera.setTorchMode(cameralist, true)
                button.setBackgroundResource(R.drawable.bulbon)
                reaa.setBackgroundResource(R.color.black)
                reaa.setBackgroundResource(R.drawable.rooflamp)
                isFlash = true;
            }
            else
            {
                val cameralist = camera.cameraIdList[0]
                camera.setTorchMode(cameralist, false)
                button.setBackgroundResource(R.drawable.bulboff)
                reaa.setBackgroundResource(R.color.black)
                isFlash = false;
            }
        }
    }

