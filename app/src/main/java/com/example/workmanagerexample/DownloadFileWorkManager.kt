package com.example.workmanagerexample

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class DownloadFileWorkManager(context:Context, workerParams:WorkerParameters):Worker(context,workerParams ) {
    override fun doWork(): Result {
        try {
            return Result.success()

        }catch (e:Exception){
            return Result.failure()
        }
    }
}