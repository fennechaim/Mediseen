using RestSharp;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace MediseenTestServiceAccessor.FdaService
{
	public class FdaServiceProvider
	{
		private const string BASE_URL = "https://api.fda.gov/drug/event.json?search=patient.reaction.reactionmeddrapt.exact:";
		
		public async Task<ReactionProviderResponse> GetReactionProviderResponse(string reactionName)
		{
			ReactionProviderResponse response = new ReactionProviderResponse();

			var client = new RestClient(BASE_URL+ reactionName+"&count=patient.drug.activesubstance.activesubstancename.exact");

			var request = new RestRequest( Method.GET);
			
			// or automatically deserialize result
			// return content type is sniffed but can be explicitly set via RestClient.AddHandler();
			var result = client.Execute<ReactionProviderResponse>(request);
			response = result.Data;

			return response;
		}

	}
}
