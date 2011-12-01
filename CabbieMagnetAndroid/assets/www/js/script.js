function init() {
	
	// Wait for PhoneGap to load	
    //
    document.addEventListener("deviceready", onDeviceReady, false);
   
    // PhoneGap is ready
    //
 
    $("#locationmenu").live('expand', function() {
        toggleLocation();
    }).live('collapse', function() {
        toggleLocation();
    });

    $(function(){
        $("#phone").text("My telephone number is: " + 
                window.MyCls.getTelephoneNumber());
    });
}

function onDeviceReady() {
    var element = document.getElementById('deviceProperties');

   /* element.innerHTML = 'Device Name: '     + device.name     + '<br />' + 
                        'Device PhoneGap: ' + device.phonegap + '<br />' + 
                        'Device Platform: ' + device.platform + '<br />' + 
                        'Device UUID: '     + device.uuid     + '<br />' + 
                        'Device Version: '  + device.version  + '<br />';
    navigator.notification.alert("PhoneGap is working"); */
}
var locationWatch = false;

var toggleLocation = function() {
    var suc = function(p) {
        jQuery("#loctext").empty();
                
        var text = "<div class=\"locdata\">Latitude: " + p.coords.latitude
                + "<br/>" + "Longitude: " + p.coords.longitude + "<br/>"
                + "Accuracy: " + p.coords.accuracy + "m<br/>" + "</div>";
        jQuery("#locdata").append(text);

        var image_url = "http://maps.google.com/maps/api/staticmap?sensor=false&center="
                + p.coords.latitude
                + ","
                + p.coords.longitude
                + "&zoom=13&size=280x175&markers=color:blue|"
                + p.coords.latitude + ',' + p.coords.longitude;

        jQuery("#map").remove();
        jQuery("#loccontainer").append(
                jQuery(document.createElement("img")).attr("src", image_url)
                        .attr('id', 'map'));
    };
    var fail = function(error) {
        jQuery("#loctext").empty();
        switch (error.code) {
        case error.PERMISSION_DENIED:
            alert("User did not share geolocation data.");
            break;

        case error.POSITION_UNAVAILABLE:
            alert("Could not detect current position.");
            break;

        case error.TIMEOUT:
            alert("Retrieving position timed out.");
            break;

        default:
            alert("Unknown error.");
            break;
        }
    };

    if (locationWatch) {
        locationWatch = false;
        jQuery("#loctext").empty();
        jQuery("#locdata").empty();
        jQuery("#map").remove();
    } else {
        if (navigator.geolocation) {
            jQuery("#loctext").append("Getting geolocation . . .");
            navigator.geolocation.getCurrentPosition(suc, fail);
        } else {
            jQuery("#loctext").empty();
            jQuery("#loctext").append("Unable to get location.");
            alert("Device or browser can not get location.");
        }
        locationWatch = true;
    }
};

function check_network() {
    var networkState = navigator.network.connection.type;

    var states = {};
    states[Connection.UNKNOWN]  = 'Unknown connection';
    states[Connection.ETHERNET] = 'Ethernet connection';
    states[Connection.WIFI]     = 'WiFi connection';
    states[Connection.CELL_2G]  = 'Cell 2G connection';
    states[Connection.CELL_3G]  = 'Cell 3G connection';
    states[Connection.CELL_4G]  = 'Cell 4G connection';
    states[Connection.NONE]     = 'No network connection';

    confirm('Connection type:\n ' + states[networkState]);
}

function getCompaniesJson() {
	var companiesURL = "http://87.104.116.90:666/CabbieMagnetWS/companies";
	if (!companiesURL)
		return false;

	var stage = $('#companies');

	/* Forming the query: */
	var query = "select * from json where url='" + companiesURL +"'";

	/* Forming the URL to YQL: */
	var url = "http://query.yahooapis.com/v1/public/yql?q="
			+ encodeURIComponent(query) + "&format=json&callback=?";
	var obj = "";
	$.getJSON(url, function(data) {

		stage.empty();

		/* item exists in JSON array: */
		$.each(data.query.results.json.company, function() {
			try {
				/*
				 * Trying to call the user provided function, "this" the rest of
				 * the json data:
				 */

				stage.append("<h2>Name: "+ this.name.toString() + "</h2><br /><h3>Location: "+ this.location.toString() + "</h3><br />");
				
			} catch (e) {
				/*
				 * Notifying users if there are any problems with their handler
				 * functions:
				 */
				stage.append('<div>There is a problem with your da stuff</div>');
				return false;
			}
		});
		
	});

}
