package com.example.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.profile.databinding.ActivityEditBinding
import com.example.profile.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etName.setText(intent.extras?.getString(getString(R.string.key_name)))
        binding.etMail.setText(intent.extras?.getString(getString(R.string.key_mail)))
        binding.etWebSite.setText(intent.extras?.getString(getString(R.string.key_website)))
        binding.etPhoneNumber.setText(intent.extras?.getString(getString(R.string.key_phone)))
        binding.etLatitude.setText(
            intent.extras?.getDouble(getString(R.string.key_latitude))
                .toString()
        )
        binding.etLongitude.setText(
            intent.extras?.getDouble(getString(R.string.key_longitud))
                .toString()
        )

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {
            sendData()
        } else if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onContextItemSelected(item)
    }

    private fun sendData() {
        val intent = Intent()
        intent.putExtra(getString(R.string.key_name), binding.etName.text)
        intent.putExtra(getString(R.string.key_mail), binding.etMail.text)
        intent.putExtra(getString(R.string.key_website), binding.etWebSite.text)
        intent.putExtra(getString(R.string.key_phone), binding.etPhoneNumber.text)
        intent.putExtra(
            getString(R.string.key_latitude),
            binding.etLatitude.text.toString().toDouble()
        )
        intent.putExtra(
            getString(R.string.key_longitud),
            binding.etLongitude.text.toString().toDouble()
        )

        setResult(RESULT_OK, intent)
        finish()
    }


}