package com.socialdragon.android.tukio.presentation.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.socialdragon.android.tukio.R
import com.socialdragon.android.tukio.domain.models.OnboardingItem

class OnboardingViewPagerAdapter(private val items: Array<OnboardingItem>): RecyclerView.Adapter<OnboardingViewPagerAdapter.OnboardingPagerViewHolder>() {
    inner class OnboardingPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_onboarding, parent, false)
        return OnboardingPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingPagerViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.findViewById<ImageView>(R.id.onboardingViewPagerItemImage).setImageResource(item.image)
        holder.itemView.findViewById<TextView>(R.id.onboardingViewPagerItemTitle).setText(item.title)
    }

    override fun getItemCount(): Int = items.size
}