package com.miled.presentation.ui.advertisement.listing

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.miled.commun.toPriceFormat
import com.miled.core.extentions.getContext
import com.miled.core.extentions.inflate
import com.miled.core.extentions.loadUrl
import com.miled.presentation.R
import com.miled.presentation.ui.models.AdvertisementUI

class AllAdsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClickListener: ((Int) -> Unit)? = null

    var items = emptyList<AdvertisementUI?>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /**
     * Implementation Section
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StorieViewHolder(parent.inflate(R.layout.item_single_ads))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener { itemClickListener?.invoke(item?.id!!) }

        with(holder as StorieViewHolder) {
            with(item as AdvertisementUI) {
                draweeAdsPicture.loadUrl(this.url)
                textAdsType.text = this.propertyType
                textAdsPrice.text = this.price.toPriceFormat()

                if (this.rooms != 0) {
                    textRoomNumber.visibility = View.VISIBLE
                    textRoomNumber.text =
                        getContext().resources.getString(R.string.text_ads_rooms, this.rooms)
                }

                if (this.bedrooms != 0) {
                    textBedroomNumber.visibility = View.VISIBLE
                    textBedroomNumber.text =
                        getContext().resources.getString(R.string.text_ads_bedrooms, this.bedrooms)
                }

                if (this.area != 0.0) {
                    textArea.visibility = View.VISIBLE
                    textArea.text =
                        getContext().resources.getString(R.string.text_ads_area, this.area)
                }

                textAdsCity.text = this.city
            }
        }
    }

    /**
     * View holder for [Stories] [View]
     */
    class StorieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val draweeAdsPicture: SimpleDraweeView = view.findViewById(R.id.drawee_ads_picture)
        val textAdsType: AppCompatTextView = view.findViewById(R.id.text_ads_type)
        val textAdsPrice: AppCompatTextView = view.findViewById(R.id.text_ads_price)
        val textRoomNumber: AppCompatTextView = view.findViewById(R.id.text_room_number)
        val textBedroomNumber: AppCompatTextView = view.findViewById(R.id.text_bedroom_number)
        val textArea: AppCompatTextView = view.findViewById(R.id.text_area)
        val textAdsCity: AppCompatTextView = view.findViewById(R.id.text_ads_city)
    }
}
