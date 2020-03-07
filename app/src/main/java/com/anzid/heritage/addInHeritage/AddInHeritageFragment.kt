package com.anzid.heritage.addInHeritage

import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.navigation.fragment.findNavController
import com.anzid.core.base.BaseFragment
import com.anzid.heritage.R
import com.anzid.heritage.hideOrShowMainToolbar
import com.google.android.material.snackbar.Snackbar
import com.polyak.iconswitch.IconSwitch
import kotlinx.android.synthetic.main.add_in_heritage_fragment.*

class AddInHeritageFragment : BaseFragment<AddInHeritageViewModel>() {

    override val fragmentLayout = R.layout.add_in_heritage_fragment
    override fun getViewModelClass() = AddInHeritageViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
    }

    override fun initListeners() {
        add_in_heritage_toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        age_fluid_slider.beginTrackingListener = { select_age_text_view.visibility = INVISIBLE }
        age_fluid_slider.endTrackingListener = { select_age_text_view.visibility = VISIBLE }
        profile_avatar.setOnClickListener { showSelectProfileAvatarDialog() }
        switch_die.setCheckedChangeListener { handleSwitchDie(it) }

        add_in_heritage_toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.add_person) Snackbar.make(coordinator, "Is developing", Snackbar.LENGTH_LONG).show(); true
        }
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

    private fun handleSwitchDie(current: IconSwitch.Checked) {
        if (current == IconSwitch.Checked.RIGHT) {
            rip_button.visibility = VISIBLE
            date_died_container.visibility = VISIBLE
            age_container.visibility = GONE
            container.setBackgroundColor(resources.getColor(R.color.colorBackgroundDark))
        } else {
            rip_button.visibility = INVISIBLE
            date_died_container.visibility = INVISIBLE
            age_container.visibility = VISIBLE
            container.setBackgroundColor(resources.getColor(R.color.colorBackgroundLight))
        }
    }

    private fun showSelectProfileAvatarDialog() {
        Snackbar.make(coordinator, "Is developing", Snackbar.LENGTH_LONG).show()
    }
}
