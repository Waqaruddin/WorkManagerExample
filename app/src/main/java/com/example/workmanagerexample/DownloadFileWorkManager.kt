package com.example.workmanagerexample

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.ContextCompat.getSystemService
import androidx.work.Worker
import androidx.work.WorkerParameters


class DownloadFileWorkManager(context: Context, workerParams: WorkerParameters):Worker(context, workerParams) {

    override fun doWork(): Result {
        try {
            startDownloading()
            return Result.success()

        }catch (e: Exception){
            return Result.failure()
        }


    }

    private fun startDownloading() {

        var url = ""
        var request = DownloadManager.Request(Uri.parse(url))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
        request.setTitle("Download")
        request.setDescription("Downloading file..")
        request.allowScanningByMediaScanner()
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                "" + System.currentTimeMillis()
        )

        //val manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        //manager.enqueue(request)
    }


}