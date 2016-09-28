$(document)
		.ready(
				function() {
					setTimeout(showPopup(), 1000);
					$(".data-submit")
							.on(
									"click",
									function(e) {
										if ($("#textData").val() == ""
												&& $("#fileData").val() == "") {
											$("#successMsg").text("");
											$("#serverError").text("");
											$("#validationError")
													.text(
															"Enter valid json/xml text or Upload file.");
											$('#myModal').modal('show');
											return;
										}
										if ($("#textData").val() != ""
												&& $("#fileData").val() != "") {
											$("#successMsg").text("");
											$("#serverError").text("");
											$("#validationError").text(
													"please choose one.");
											$('#myModal').modal('show');
											return;
										}

										if ($("#textData").val() != "") {
											$("#ingestData").remove("#fileData");
											$('#ingestData').attr('enctype','');
										} else {
											$("#ingestData")
													.remove("#textData");
											$('#ingestData').attr('action',
													'ingestFile');
											$('#ingestData').attr('enctype',
													'multipart/form-data');
										}
										$('#ingestData').submit();
									});
				});


function showPopup(){
	if($("#successMsg").text()!="" || $("#serverError").text()!="")
		$('#myModal').modal('show');
	
}
