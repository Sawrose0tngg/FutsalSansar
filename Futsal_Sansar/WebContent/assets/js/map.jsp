<script>
	function initMap() {
		var options = {
			zoom : 15,
			center : {
				lat : 27.672115,
				lng : 85.428339
			}
		}
		var map = new google.maps.Map(document.getElementById('map'), options);
		var marker = new google.maps.Marker({
			position : {
				lat : 27.672115,
				lng : 85.428339
			},
			map : map
		});
	}
</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALiT_gYVHlW1lfF7HUUZKTPj-CRB6-lVM&callback=initMap"></script>