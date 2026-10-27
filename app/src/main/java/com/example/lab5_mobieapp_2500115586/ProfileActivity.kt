package com.example.lab5_mobieapp_2500115586

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById theo yêu cầu đề bài
        val tvProfileTitle: TextView = findViewById(R.id.tvProfileTitle)
        val tvUserEmail: TextView = findViewById(R.id.tvUserEmail)
        val btnLogout: Button = findViewById(R.id.btnLogout)

        // Nhận dữ liệu Email từ Intent sang
        val userEmail = intent.getStringExtra("EMAIL_EXTRA") ?: ""
        tvUserEmail.text = "Email: $userEmail"

        // Xử lý nút Đăng xuất đóng Activity hiện tại
        btnLogout.setOnClickListener {
            finish()
        }
    }
}