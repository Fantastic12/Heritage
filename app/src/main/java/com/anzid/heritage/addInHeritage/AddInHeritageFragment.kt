package com.anzid.heritage.addInHeritage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.anzid.heritage.R

class AddInHeritageFragment : Fragment() {

    companion object {
        fun newInstance() = AddInHeritageFragment()
    }

    private lateinit var viewModel: AddInHeritageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_in_heritage_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddInHeritageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
