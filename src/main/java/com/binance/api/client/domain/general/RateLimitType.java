package com.binance.api.client.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Rate limiters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum RateLimitType {

	REQUEST_WEIGHT, ORDERS, REQUESTS

}
