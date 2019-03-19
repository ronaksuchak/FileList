package com.example.filelist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


class MainActivity : AppCompatActivity() {
    var fileArray = arrayListOf<FileModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val path = Environment.getExternalStorageDirectory().toString()
        Log.e("Files", "Path: $path")
        val directory = File(path)
        val files = directory.listFiles()

        Log.e("Files", "Size: ${files.indices}")
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FileAdaptor(fileArray, this)

        for (i in files.indices) {
            Log.e("Files", "FileName:" + files[i].name)
            fileArray.add(FileModel(files[i].name, files[i].isDirectory))
        }
    }
}
