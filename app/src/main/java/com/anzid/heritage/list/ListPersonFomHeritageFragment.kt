package com.anzid.heritage.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.anzid.heritage.R
import kotlinx.android.synthetic.main.list_person_fom_haritage_fragment.*

class ListPersonFomHeritageFragment : Fragment() {

    companion object {
        fun newInstance() = ListPersonFomHeritageFragment()
    }

    private lateinit var viewModel: ListPersonFomHeritageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_person_fom_haritage_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(list_person)
        initListeners()
    }

    private fun initListeners() {
        add_person.setOnClickListener { findNavController().navigate(R.id.action_list_to_addInHeritageFragment) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListPersonFomHeritageViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = PersonListRecyclerViewAdapter()
    }
}
