package com.beyondguo.androidgoo.goga.menus

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.beyondguo.androidgoo.databinding.ActivityPackageManagerTestBinding


class GogaPackageManagerActivity : AppCompatActivity(), GogaMenuInterface {

    private var _binding: ActivityPackageManagerTestBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPackageManagerTestBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btn1.setOnClickListener {
            binding.text.text = getPackageInfo(this, 1).toString()
        }
        binding.btn2.setOnClickListener {
            binding.text.text = getPackageManager(this).getInstalledPackages(0)
                .filter { it.packageName == this.packageName }.toString()
        }
        binding.btn3.setOnClickListener {
            binding.text.text = getPackageManager(this).getInstalledApplications(1).toString()
        }
        binding.btn3.setOnClickListener {
            binding.text.text = getPackageInfo(this, 1)?.packageName ?: "未获取到"
        }

    }

    private fun getPackageManager(context: Context): PackageManager {
        return context.packageManager
    }

    private fun getPackageInfo(context: Context, flag: Int): PackageInfo? {
        try {
            return getPackageManager(context).getPackageInfo(context.packageName, flag)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 获取包名
     */
    @Synchronized
    fun getPackageName(context: Context): String? {
        return context.packageName
    }

    fun getFirstInstallTime(context: Context): Long? {
        val packageInfo = getPackageInfo(context, 0)
        return packageInfo?.firstInstallTime
    }

    fun getLastUpdateTime(context: Context): Long? {
        val packageInfo = getPackageInfo(context, 0)
        return packageInfo?.lastUpdateTime
    }

    /**
     * 获取已安装的 app列表
     * @param context
     * @return
     */
    fun getInstlledPackages(context: Context): List<PackageInfo?>? {
        val uninstalled =
            if (Build.VERSION.SDK_INT >= 24) PackageManager.MATCH_UNINSTALLED_PACKAGES else PackageManager.GET_UNINSTALLED_PACKAGES
        return getPackageManager(context).getInstalledPackages(uninstalled)
    }
}