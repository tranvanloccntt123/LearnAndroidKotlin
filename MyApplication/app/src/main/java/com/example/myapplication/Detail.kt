package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.viewmodal.DetailViewModal
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ListAdapter
import com.example.myapplication.database.ItemDetail

class Detail : Fragment(){
    public val TAG:String = "DETAIL"
    var listName = listOf<String>("Tran Van Loc", "Tran Thi Ngoc Bich", "Pham Thi My Duyen", "Tran Anh Tai", "Nguyen Thi Minh Anh", "Truong Thi Thanh Xuan")
    private lateinit var model : DetailViewModal
    private var adapter = ListAdapter()
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Detail Learn Kotlin", "Create View")
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        //learn view model
        learnViewModel(binding)
        //learn recycle view
        learnRecycleView(binding)
        setHasOptionsMenu(true)
        return binding.root
    }

    fun learnRecycleView(binding: FragmentDetailBinding){
        //add item
        for (i in 0..5){
            var items : ItemDetail = ItemDetail(i.toLong(), listName[i])
            adapter.pushData(items)
        }
        LinearLayoutManager(activity).also { binding.listItem.layoutManager = it }
        //link adapter
        binding.listItem.adapter = adapter
    }

    fun learnViewModel(binding: FragmentDetailBinding){
        model = activity?.let {
            ViewModelProviders.of(it)[DetailViewModal::class.java]
        }!!
        //learn ViewModel
        binding.button2.setOnClickListener(View.OnClickListener {
            model.correct()
        })
        //binding view model to xml
        binding.scoreViewModel = model
        binding.setLifecycleOwner(this)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.shareButton -> startActivity(getShareIntent())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent() : Intent{
        val shareIntent:Intent = Intent()
        shareIntent.setAction(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Message to send...")
        return shareIntent
    }
}