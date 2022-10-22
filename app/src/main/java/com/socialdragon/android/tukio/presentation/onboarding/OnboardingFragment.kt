package com.socialdragon.android.tukio.presentation.onboarding

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.socialdragon.android.tukio.R
import com.socialdragon.android.tukio.domain.models.OnboardingItem
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnboardingFragment : Fragment() {

    companion object {
        fun newInstance() = OnboardingFragment()
    }

    private lateinit var onboardingViewPagerAdapter: OnboardingViewPagerAdapter
    private lateinit var onboardingViewPager: ViewPager2
    private lateinit var onboardingDotIndicator: DotsIndicator
    private lateinit var onboardingControlButton: Button

    private val items = arrayOf<OnboardingItem>(
        OnboardingItem(
            R.drawable.onboarding_1,
            R.string.onboarding_title_1,
        ),
        OnboardingItem(
            R.drawable.onboarding_2,
            R.string.onboarding_title_2,
        ), OnboardingItem(
            R.drawable.onboarding_3,
            R.string.onboarding_title_3,
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onboardingViewPagerAdapter = OnboardingViewPagerAdapter(items)
        onboardingViewPager = view.findViewById(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingViewPagerAdapter
        onboardingViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == onboardingViewPagerAdapter.itemCount - 1) {
                    onboardingControlButton.setText(R.string.get_started)
                } else {
                    onboardingControlButton.setText(R.string.next)
                }
            }
        })

        onboardingDotIndicator = view.findViewById(R.id.onboardingDotIndicator)
        onboardingDotIndicator.attachTo(onboardingViewPager)

        onboardingControlButton = view.findViewById(R.id.onboardingControlButton)
        onboardingControlButton.setText(R.string.next)
        onboardingControlButton.setOnClickListener(this::onClickListener)
    }

    private fun onClickListener(@Suppress("UNUSED_PARAMETER") view: View) {
        if (onboardingViewPager.currentItem == onboardingViewPagerAdapter.itemCount - 1) {
            findNavController().navigate(R.id.letUsInFragment)
        } else {
            onboardingViewPager.currentItem++
        }
    }
}