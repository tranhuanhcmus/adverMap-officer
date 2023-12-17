import { AuthFieldForm } from "../../components/login/login";
import { api } from "../apis/index.tsx"
import { API } from "../apis/constants.tsx"

export class AuthService {
	
	static login = async (data: AuthFieldForm) => {
		try {
			const response = await api.post(API.AUTH,data)
			return {
				status: response.status,
				message: response.data.message,
				data: response.data.data
			};
		} catch (error) {
			throw error
		}
	}
}

