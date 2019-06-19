using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
//using System.Web.Http;
using MediseenTestServiceAccessor.FdaService;
using Microsoft.AspNetCore.Mvc;

namespace MediseenTestApi.Controllers
{

	//[RoutePrefix("api/ingredients")]
	[Route("api/ingredients")]
	[ApiController]
	public class MediseenController :ControllerBase
    {

		private readonly FdaServiceProvider _fdaServiceProvider;
		
		public MediseenController(FdaServiceProvider fdaServiceProvider)
		{
			this._fdaServiceProvider = fdaServiceProvider;
		}

		//https://localhost:5001/api/ingredients/reaction?name=death
		[Route("reaction")]
		[HttpGet]
		public async Task<List<ReactionActiveIngredient>> GetReactionActiveIngredients([System.Web.Http.FromUri]string name)
		{
			List<ReactionActiveIngredient> response = new List<ReactionActiveIngredient>();

			var result = await this._fdaServiceProvider.GetReactionProviderResponse(name);

			return result.results.OrderByDescending(x=>x.count).ToList().Take(10).ToList();
	
		}
    }
}