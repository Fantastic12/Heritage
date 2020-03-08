package com.anzid.heritage.addInHeritage

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.anzid.core.base.FragmentViewModelInjection
import com.anzid.heritage.R
import com.anzid.heritage.extensions.hideOrShowMainToolbar
import com.anzid.heritage.extensions.invisible
import com.anzid.heritage.extensions.visible
import com.google.android.material.snackbar.Snackbar
import com.polyak.iconswitch.IconSwitch
import kotlinx.android.synthetic.main.add_in_heritage_content.*
import kotlinx.android.synthetic.main.add_in_heritage_fragment.*

class AddInHeritageFragment : FragmentViewModelInjection<AddInHeritageViewModel>() {

    override val fragmentLayout = R.layout.add_in_heritage_fragment
    override fun getViewModelClass() = AddInHeritageViewModel::class.java

    private lateinit var datePickerDialog: DatePickerDialog

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        datePickerDialog = DatePickerDialog(requireContext())
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun initListeners() {
        add_in_heritage_toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        age_fluid_slider.beginTrackingListener = { select_age_text_view.invisible() }
        age_fluid_slider.endTrackingListener = { select_age_text_view.visible() }
        profile_avatar.setOnClickListener { showSelectProfileAvatarDialog() }
        switch_die.setCheckedChangeListener { handleSwitchDie(it) }
        date_birthday_calendar.setOnClickListener { showDateDialog() }
        datePickerDialog.setOnDateSetListener { _, year, month, day -> handleSelectedDate(day, month, year) }

        add_in_heritage_toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.add_person) Snackbar.make(coordinator, "Is developing", Snackbar.LENGTH_LONG).show(); true
        }
    }

    @SuppressLint("SetTextI18n")
    private fun handleSelectedDate(day: Int, month: Int, year: Int) {
        selected_birthday_date.text = "$day/${month + 1}/$year"
        selected_birthday_date.visible()
        date_birthday_calendar.invisible()
    }

    private fun showDateDialog() {
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().hideOrShowMainToolbar(true)
    }

    private fun initToolbar() {
        requireActivity().hideOrShowMainToolbar(false)
        add_in_heritage_toolbar.inflateMenu(R.menu.add_to_heritage_menu)
        add_in_heritage_toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    private fun handleSwitchDie(current: IconSwitch.Checked) = when (current) {
        IconSwitch.Checked.RIGHT -> handleRightSwitchState()
        IconSwitch.Checked.LEFT -> handleLeftSwitchState()
    }

    private fun handleRightSwitchState() {
        rip_button.visibility = VISIBLE
        date_died_container.visibility = VISIBLE
        age_container.visibility = GONE
        container.setBackgroundColor(resources.getColor(R.color.colorBackgroundDark))
    }

    private fun handleLeftSwitchState() {
        rip_button.visibility = INVISIBLE
        date_died_container.visibility = INVISIBLE
        age_container.visibility = VISIBLE
        container.setBackgroundColor(resources.getColor(R.color.colorBackgroundLight))
    }

    private fun showSelectProfileAvatarDialog() {
        Snackbar.make(coordinator, "Is developing", Snackbar.LENGTH_LONG).show()
    }
}
