<script>
	$(document)
			.ready(
					function() {
						var showChar = 500; // How many characters are shown by default
						var ellipsestext = "...";
						var moretext = "Show more";
						var lesstext = "Show less";

						$('.moreContent')
								.each(
										function() {
											var content = $(this).html();

											if (content.length > showChar) {

												var c = content.substr(0,
														showChar);
												var h = content.substr(
														showChar,
														content.length
																- showChar);

												var html = c
														+ '<span class="moreellipses">'
														+ ellipsestext
														+ '&nbsp;</span><span class="morecontent"><span>'
														+ h
														+ '</span>&nbsp;&nbsp;<a href="" class="morelink">'
														+ moretext
														+ '</a></span>';

												$(this).html(html);
											}

										});

						$(".morelink").click(function() {
							if ($(this).hasClass("less")) {
								$(this).removeClass("less");
								$(this).html(moretext);
							} else {
								$(this).addClass("less");
								$(this).html(lesstext);
							}
							$(this).parent().prev().toggle();
							$(this).prev().toggle();
							return false;
						});
					});
	$('#showdiv1').click(function() {
		$('div[id=div2]').hide();
		$('div[id=div3]').hide();
		$('#div1').show();
		$("#li1").attr("class", "active");
		$("#li2").attr("class", "");
		$("#li3").attr("class", "");
	});
	$('#showdiv2').click(function() {
		$('div[id=div1]').hide();
		$('div[id=div3]').hide();
		$('#div2').show();
		$("#li2").attr("class", "active");
		$("#li1").attr("class", "");
		$("#li3").attr("class", "");
	});

	$('#showdiv3').click(function() {
		$('div[id=div1]').hide();
		$('div[id=div2]').hide();
		$('#div3').show();
		$("#li3").attr("class", "active");
		$("#li1").attr("class", "");
		$("#li2").attr("class", "");
	});
	$('#upevent').click(function() {
		$('div[id=section2]').hide();
		$('#section1').show();
		$("#event1").attr("class", "active");
		$("#event2").attr("class", "");
	});
	$('#comevent').click(function() {
		$('div[id=section1]').hide();
		$('#section2').show();
		$("#event2").attr("class", "active");
		$("#event1").attr("class", "");
	});
	$('#section2').hide();
	$("#event1").attr("class", "active");
	$("#li1").attr("class", "active");
	$('div[id=div2]').hide();
	$('div[id=div3]').hide();
</script>