package com.ziggy192.interviews.zalora.shipment;

/*
/*Shipment module
+ Shipment Provider
++ viettel ( PING_URL : http://viettel.com/ping, SHIP_URL : http://viettel.com/ship) : Json Format
++ vnpt ( PING_URL : http://vnpt.com/ping, SHIP_URL : http://vnpt.com/ship) : Raw Data
++ ghn ( PING_URL : http://ghn.com/ping, SHIP_URL : http://ghn.com/ship) : upload CSV file


+ methods :
++ ship()  : each provider might have different post data format
+++ Provider viettel : Json Format
+++ Provider VNPT : Raw Data
+++ Provider GHN : upload CSV file

++ ping() : ping URL  : all provider should have the same way. just check http response code if 200 return true else return false


Input data :
array (
 "itemName" => "Mac Book Pro",
 "price" => "1200",
 "customer" =>  {
 	"name" => "John Smith",
 	"address" => "12 Ton dan",
 	"tel" => "01234456"
  }
)
Note : we need remove "price" before sending to shipment provider.

*/

class Package {
	String itemName;
	float price;
	Customer customer;
}

class Customer {
	String name;
	String address;
	String tel;
}

public class ShipmentService {
	private Vendor vendor;

	public ShipmentService(Vendor vendor) {
		this.vendor = vendor;

	}

	public boolean doShipment(Package pack) {
		if (pack == null) {
			throw new RuntimeException("Package should not be null");
		}
		// remove price out of package
		pack.price = 0;
		// call ship
		return vendor.ship(pack);
	}

	public boolean ping() {
		String url = ""; // vendor.getPingUrl
		// do ping

		return vendor.ping();
	}
}

class PingHandler {
	public boolean ping(String url) {
		return false;
	}
}

// Json Format
class ViettelVendor implements Vendor {
	//PING_URL : http://viettel.com/ping, SHIP_URL : http://viettel.com/ship
	String pingUrl;
	String shipUrl;
	PingHandler pingHandler;

	@Override
	public boolean ping() {
		// call ping url
		return pingHandler.ping(pingUrl);
	}

	//
	@Override
	public boolean ship(Package pack) {
		return false;
	}
}


interface Vendor {
	public boolean ping();

	public boolean ship(Package pack);
}
