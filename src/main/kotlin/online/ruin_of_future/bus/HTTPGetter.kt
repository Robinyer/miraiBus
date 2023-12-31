package online.ruin_of_future.bus

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class HTTPGetter {
    private var client = OkHttpClient()

    @Throws(IOException::class)
    suspend fun get(url: String): String {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute().use { response -> return response.body!!.string() }
    }
}