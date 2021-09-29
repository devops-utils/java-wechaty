package io.github.wechaty.utils

import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import java.util.*

const val MAX_LEN = 7089

class QrcodeUtils {


    companion object {

        @JvmStatic
        fun getQr(text: String): String {
            var s: String = "生成二维码失败"
            val width = 30
            val height = 30
            // 用于设置QR二维码参数
            val qrParam: Hashtable<EncodeHintType, Any> = Hashtable<EncodeHintType, Any>()
            // 设置QR二维码的纠错级别——这里选择最低L级别
            qrParam[EncodeHintType.ERROR_CORRECTION] = ErrorCorrectionLevel.L
            qrParam[EncodeHintType.CHARACTER_SET] = "utf-8"
            System.out.println(text)
            try {
                val bitMatrix: BitMatrix = MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, qrParam)
                s = toAscii(bitMatrix)
            } catch (e: WriterException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            return s
        }

        fun toAscii(bitMatrix: BitMatrix): String {
            val sb = StringBuilder()
            for (rows in 0 until bitMatrix.getHeight()) {
                for (cols in 0 until bitMatrix.getWidth()) {
                    val x: Boolean = bitMatrix.get(rows, cols)
                    if (!x) {
                        // white
                        sb.append("\u001b[47m  \u001b[0m")
                    } else {
                        sb.append("\u001b[30m  \u001b[0m")
                    }
                }
                sb.append("\n")
            }
            return sb.toString()
        }

        @JvmStatic
        fun guardQrCodeValue(value: String): String {
            if (value.length > MAX_LEN) {
                throw Exception("QR Code Value is larger then the max len. Did you return the image base64 text by mistake? See: https://github.com/wechaty/wechaty/issues/1889")
            }
            return value
        }
    }

}
