package com.example.lab5_mobieapp_2500115586

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ View bằng findViewById theo yêu cầu đề bài
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvStatus: TextView = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.text = "Vui lòng nhập đầy đủ Email và Mật khẩu!"
                tvStatus.setTextColor(resources.getColor(android.R.color.holo_red_dark, theme))
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.text = "Email không đúng định dạng!"
                tvStatus.setTextColor(resources.getColor(android.R.color.holo_red_dark, theme))
            } else if (password.length < 6) {
                tvStatus.text = "Mật khẩu phải chứa ít nhất 6 ký tự!"
                tvStatus.setTextColor(resources.getColor(android.R.color.holo_red_dark, theme))
            } else {
                tvStatus.text = "Đăng nhập hợp lệ"
                tvStatus.setTextColor(resources.getColor(android.R.color.holo_green_dark, theme))

                // Sử dụng Intent chuyển từ LoginActivity sang ProfileActivity và truyền Email
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    putExtra("EMAIL_EXTRA", email)
                }
                startActivity(intent)
            }
        }
    }
}