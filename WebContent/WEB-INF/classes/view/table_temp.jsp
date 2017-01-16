<table class="table table-hover">
					<thead>
						<tr>
							<th></th>
							<th>Flugnummer</th>
							<th>Preis (euro)</th>
							<th>Abflugsdatum</th>
							<th>Ankunftsdatum</th>
							<th>Abflugsort</th>
							<th>Ankunftsort</th>
							<th>Anzahl Freiplätze</th>
						</tr>
					</thead>
					<tbody>
				<%
						for(int i=0; i<flugnrList.size(); i++) {
							String new_id = new String();
							new_id = "flug" + i;

							String value = new String();
							value += flugnrList.get(i) + "#" + abDatList.get(i);
				%>
							<tr>
								<td><input id='<%= new_id %>' type="radio" name="flug" value=<%= value %> /></td>
								<td><label for=<%= new_id %> style="font-weight: normal;"><%= flugnrList.get(i) %></label></td>
								<td class="tcenter"><label for=<%= new_id %> style="font-weight: normal;"><%= preisList.get(i) %></label></td>
								<td class="tcenter"><label for=<%= new_id %> style="font-weight: normal;"><%= abDatList.get(i) %></label></td>
								<td class="tcenter"><label for=<%= new_id %> style="font-weight: normal;"><%= anDatList.get(i) %></label></td>
								<td class="tcenter"><label for=<%= new_id %> style="font-weight: normal;"><%= abOrtList.get(i) %></label></td>
								<td class="tcenter"><label for=<%= new_id %> style="font-weight: normal;"><%= anOrtList.get(i) %></label></td>
								<td class="tcenter"><label for=<%= new_id %> style="font-weight: normal;"><%= freiplatzList.get(i) %></label></td>
							</tr>
				<%
						}	
					}
				%>
					</tbody>
				</table>
			</form>
		</div>