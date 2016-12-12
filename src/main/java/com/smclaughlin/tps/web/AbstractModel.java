package com.smclaughlin.tps.web;

import org.springframework.ui.ModelMap;

/**
 * Created by sineadmclaughlin on 27/11/2016.
 */
public abstract class AbstractModel {


    public abstract void reset();

    public abstract String getKey();

    public void retrieveOrCreate(ModelMap model) {
        AbstractModel instanceModel;
        if (model.containsKey(getKey())) {
            instanceModel = (AbstractModel)model.get(getKey());
        } else {
            instanceModel = this;
        }
        model.put(getKey(), instanceModel);
    }
}
