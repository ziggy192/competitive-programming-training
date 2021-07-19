package com.ziggy192.leetcode;

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

public class ShipperSolution {

}

