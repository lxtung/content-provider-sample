package com.xplora.kidswatchx6

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            replaceDB()
        }, 3000)

        Handler().postDelayed({
            ContentResolverHelper(this).getAll()
        }, 5000)
    }

    private fun replaceDB() {
        val dbPath =
            "data/data/${applicationInfo?.packageName}/databases/${SampleContentProvider.DATABASE_NAME}"
        Log.i("tung", "dbPath: $dbPath")

        val input = assets.open(SampleContentProvider.DATABASE_NAME)
        val output = FileOutputStream(dbPath)

        val buffer = ByteArray(1024)
        var length: Int
        while ((input.read(buffer).also { length = it }) > 0) {
            output.write(buffer, 0, length)
        }
        output.flush()
        output.close()
        input.close()
    }
}