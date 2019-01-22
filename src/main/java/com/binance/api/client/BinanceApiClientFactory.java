package com.binance.api.client;

import com.binance.api.client.domain.DomainType;
import com.binance.api.client.impl.BinanceApiAsyncRestClientImpl;
import com.binance.api.client.impl.BinanceApiRestClientImpl;
import com.binance.api.client.impl.BinanceApiWebSocketClientImpl;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.getSharedClient;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceApiClientFactory {

	/**
	 * API Key
	 */
	private String apiKey;

	/**
	 * API Secret
	 */
	private String secret;


	/**
	 * Represent user region. Com, US
	 */
	private DomainType domainType = DomainType.Com;

	/**
	 * Instantiates a new binance api client factory.
	 *
	 * @param apiKey the API key
	 * @param secret the Secret
	 */
	private BinanceApiClientFactory(String apiKey, String secret, DomainType domainType) {
		this.apiKey = apiKey;
		this.secret = secret;
		this.domainType = domainType;
	}

	@Deprecated
	public static BinanceApiClientFactory newInstance(String apiKey, String secret) {
		return new BinanceApiClientFactory(apiKey, secret, DomainType.Com);
	}

	/**
	 * New instance.
	 *
	 * @param apiKey the API key
	 * @param secret the Secret
	 * @return the binance api client factory
	 */
	public static BinanceApiClientFactory newInstance(String apiKey, String secret, DomainType domainType) {
		return new BinanceApiClientFactory(apiKey, secret, domainType);
	}

	@Deprecated
	public static BinanceApiClientFactory newInstance() {
		return new BinanceApiClientFactory(null, null, DomainType.Com);
	}

	/**
	 * New instance without authentication.
	 *
	 * @return the binance api client factory
	 */
	public static BinanceApiClientFactory newInstance(DomainType domainType) {
		return new BinanceApiClientFactory(null, null, domainType);
	}

	/**
	 * Creates a new synchronous/blocking REST client.
	 */
	public BinanceApiRestClient newRestClient(DomainType domainType) {
		return new BinanceApiRestClientImpl(apiKey, secret, domainType);
	}

	@Deprecated
	public BinanceApiRestClient newRestClient() {
		return new BinanceApiRestClientImpl(apiKey, secret, domainType);
	}

	/**
	 * Creates a new asynchronous/non-blocking REST client.
	 */
	public BinanceApiAsyncRestClientImpl newAsyncRestClient(DomainType domainType) {
		return new BinanceApiAsyncRestClientImpl(apiKey, secret, domainType);
	}


	/**
	 * Creates a new asynchronous/non-blocking REST client.
	 */
	@Deprecated
	public BinanceApiAsyncRestClientImpl newAsyncRestClient() {
		return new BinanceApiAsyncRestClientImpl(apiKey, secret, domainType);
	}

	/**
	 * Creates a new web socket client used for handling data streams.
	 */
	public BinanceApiWebSocketClient newWebSocketClient(DomainType domainType) {
		return new BinanceApiWebSocketClientImpl(getSharedClient(), domainType);
	}

	@Deprecated
	public BinanceApiWebSocketClient newWebSocketClient() {
		return new BinanceApiWebSocketClientImpl(getSharedClient(), DomainType.Com);
	}

}
