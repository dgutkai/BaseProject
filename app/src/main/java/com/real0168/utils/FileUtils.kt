package com.real0168.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.nio.charset.Charset
import java.util.stream.IntStream


/**
 * Utils to process files
 *
 * Created by mengyue01@baidu.com
 */
object FileUtils {

    fun readJsonStrFromFile(filepath: String): String? {
        var json: String? = null
        try {
            val file = File(filepath)
            val fileInputstream = file.inputStream()
            val size = fileInputstream.available()
            val buffer = ByteArray(size)
            fileInputstream.read(buffer)
            fileInputstream.close()
            json = kotlin.text.String(buffer, Charset.forName("utf-8"))
        } catch (ex: Throwable) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    fun readJsonStrFromAsset(context: Context, filename: String): String? {
        var json: String? = null
        try {
            val file = context.assets.open(filename)
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()
            json = kotlin.text.String(buffer, Charset.forName("utf-8"))
        } catch (ex: Throwable) {
            ex.printStackTrace()
            return null
        }

        return json
    }
    fun readJsonFromFile(filename: String) : JSONObject? {
        try {
            return JSONObject(readJsonStrFromFile(filename))
        } catch (e: JSONException) {
            return null
        } catch (e: NullPointerException) {
            return null
        }
    }

    fun readJsonFromAsset(context: Context, filename: String) : JSONObject? {
        try {
            return JSONObject(readJsonStrFromAsset(context, filename))
        } catch (e: JSONException) {
            return null
        } catch (e: NullPointerException) {
            return null
        }
    }

    fun readBitmapFromAsset(context: Context, filename: String) : Bitmap? {

        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.RGB_565
        options.inPurgeable = true
        options.inInputShareable = true
        val asm = context.assets
        val inputStream: InputStream
        var bitmap: Bitmap? = null
        try {
            inputStream = asm.open(filename)
            bitmap = BitmapFactory.decodeStream(inputStream, null, options)
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return bitmap
    }

    private val LOG_FILE = "LogAll.txt"
    private val APP_DIR = "/DCS"
    fun getLogFilePath(): String {
        return (Environment.getExternalStorageDirectory().absolutePath
                + APP_DIR + File.separator + LOG_FILE)
    }
    /**
     * 日志追加文件
     *
     * @param content 追加的内容
     */
    fun appendStrToFile(content: String) {
        val file = File(getLogFilePath())
        if (!file.isFile()) {
            file.delete()
        }
        if (!file.exists()) {
            try {
                file.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        var out: BufferedWriter? = null
        try {
            out = BufferedWriter(OutputStreamWriter(
                    FileOutputStream(file, true)))
            out.write(content)
            out.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                out!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }
}