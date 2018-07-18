package cubex.mahesh.gallery_july730am

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.indiview.view.*
import java.io.File

class MyAdapter:BaseAdapter
{
    var files:Array<File>? = null
    var mActivity:MainActivity? = null
    constructor(mActivity:MainActivity){
        this.mActivity = mActivity
        var path = "/storage/sdcard0/WhatsApp/Media/WhatsApp Video/"
        var file = File(path)
        if(!file.exists()){
            path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Video/"
            file = File(path)
        }
       files =  file.listFiles()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var inflater = LayoutInflater.from(mActivity)
            var view = inflater.inflate(R.layout.indiview,null)

            view.vview.setVideoURI(Uri.fromFile(files!![p0]))
            view.cb1.text = files!![p0].name

            view.cb1.setOnCheckedChangeListener {
                compoundButton, b ->
                    if(b){
                        view.vview.start()
                    }else{
                        view.vview.pause()
                    }
            }

            return  view
    }

    override fun getItem(p0: Int): Any {
    return 0;
    }

    override fun getItemId(p0: Int): Long {
    return  0;
    }

    override fun getCount(): Int {
    return  files!!.size
    }

}