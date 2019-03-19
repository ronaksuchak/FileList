package com.example.filelist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FileAdaptor(val arrayList: ArrayList<FileModel>,val context:Context): RecyclerView.Adapter<FileAdaptor.FileViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FileViewHolder {
        return FileViewHolder(LayoutInflater.from(context).inflate(R.layout.list_singel,p0,false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(p0: FileViewHolder, p1: Int) {
        p0.filenameTextView.text = arrayList[p1].fileName
        if(arrayList[p1].type){
            p0.fileTypeTextView.text = "Folder"
        }else{
            p0.fileTypeTextView.text = "File"
        }
    }

    class FileViewHolder(view:View):RecyclerView.ViewHolder(view){
            val filenameTextView = view.findViewById<TextView>(R.id.textViewFileName)!!
            val fileTypeTextView = view.findViewById<TextView>(R.id.textViewType)!!
    }
}