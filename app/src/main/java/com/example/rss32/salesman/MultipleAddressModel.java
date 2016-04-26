package com.example.rss32.salesman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rss32 on 19/4/16.
 */
public class MultipleAddressModel {
    public List<AddressModel> getAddressModelList() {
        return addressModelList;
    }

    public void setAddressModelList(List<AddressModel> addressModelList) {
        this.addressModelList = addressModelList;
    }

    List<AddressModel> addressModelList = new ArrayList<>();
}
