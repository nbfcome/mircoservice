/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.models;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects.ToStringHelper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceList<T> {

    @ApiModelProperty(value = "items returned to client, in JSON format", required = true)
    @JsonProperty
    @NotNull
    @Valid
    private List<T> items;

    public ResourceList(List<T> items) {
        this.items = items;
    }

    public ResourceList() {
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return this.items;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ResourceList<T> other = (ResourceList<T>) o;

        return Objects.equals(this.getItems(), other.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getItems());
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

    protected ToStringHelper toStringHelper() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("items", this.getItems());
    }

}