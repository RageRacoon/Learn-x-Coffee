package com.RageRacoon.learm_x_coffee.utiles

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import com.RageRacoon.learm_x_coffee.R
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

import org.apache.commons.io.FileUtils



class ComposeFileProvider: FileProvider(R.xml.rutas) {
    companion object{
        fun getImgFromUri(context: Context): Uri {
            val directorio = File(context.cacheDir, "images")
            directorio.mkdirs()
            val file = File.createTempFile(
                "img_seleccionada_",
                ".jpg",
                directorio
            )
            val authority = context.packageName + ".fileprovider"
            return getUriForFile(
                context,
                authority,
                file
            )
        }
        fun createFile (context: Context, uri: Uri):File?{
            return try {
                val stream = context.contentResolver.openInputStream(uri)
                val file = File.createTempFile(
                    "${System.currentTimeMillis()}",//retorna hora actual
                    ".png",
                    context.cacheDir
                )
                FileUtils.copyInputStreamToFile(stream, file)
                return file
            } catch (e: Exception){
                e.printStackTrace()
                return null
            }
        }
        fun getPathFromBitmap(context: Context, bitmap: Bitmap): String {
            val wrapper = ContextWrapper(context)
            var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
            file = File(file,"${UUID.randomUUID()}.jpg")
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream)
            stream.flush()
            stream.close()
            return file.path
        }
    }

}