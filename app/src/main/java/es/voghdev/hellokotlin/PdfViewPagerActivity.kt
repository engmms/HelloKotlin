/*
 * Copyright (C) 2017 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.hellokotlin

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import es.voghdev.pdfviewpager.library.PDFViewPager
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter
import es.voghdev.pdfviewpager.library.asset.CopyAsset
import es.voghdev.pdfviewpager.library.asset.CopyAssetThreadImpl
import org.jetbrains.anko.toast
import java.io.File

class PdfViewPagerActivity : AppCompatActivity(), CopyAsset.Listener {
    lateinit var pdfViewPager : PDFViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val copyAsset: CopyAsset = CopyAssetThreadImpl(this, Handler(), this)
        copyAsset.copy("sample.pdf", File(cacheDir, "sample.pdf").absolutePath)
    }

    override fun onDestroy() {
        super.onDestroy()

        (pdfViewPager.adapter as PDFPagerAdapter).close()
    }

    override fun success(assetName: String?, destinationPath: String?) {
        pdfViewPager = PDFViewPager(this, "sample.pdf")

        setContentView(pdfViewPager)
    }

    override fun failure(e: Exception?) {
        toast("Error opening PDF: ${e?.message}")
    }
}
