#include <iostream>
#include <vector>

int seq(std::vector<std::vector<int>>& m) {
	int ans = INT32_MIN;
	for (auto& row : m) {
		ans = std::max(*min_element(row.begin(), row.end()), ans);
	}
	return ans;
}

int par(std::vector<std::vector<int>>& m) {
	int res = INT32_MIN;
#pragma omp parallel for default(none) shared(m, res)
	for (int i = 0; i < m.size(); ++i) {
		int local_res = *std::min_element(m[i].begin(), m[i].end());
#pragma omp critical
		{
			res = std::max(res, local_res);
		}
	}
	return res;
}

int par_nested(std::vector<std::vector<int>>& m) {
	int res = INT32_MIN;
#pragma omp parallel for default(none) shared(m, res)
	for (int i = 0; i < m.size(); ++i) {
		int local_min = INT32_MAX;
#pragma omp parallel for default(none) shared(m, local_min, i)
		for (int j = 0; j < m.size(); ++j) {
			local_min = std::min(local_min, m[i][j]);
		}
#pragma omp critical
		{
			res = std::max(local_min, res);
		}
	}
	return res;
}

int main() {
	int n = 12000;
	srand(time(NULL));
	std::vector<std::vector<int>> m(n, std::vector<int>(n));
	std::for_each(m.begin(), m.end(), [](std::vector<int>& row) {
		std::generate(row.begin(), row.end(), rand); });
	const auto start_seq = std::chrono::steady_clock::now();
	auto seq_ans = seq(m);
	const auto end_seq = std::chrono::steady_clock::now();
	const auto start_par = std::chrono::steady_clock::now();
	auto par_ans = par(m);
	const auto end_par = std::chrono::steady_clock::now();
	const auto start_par_nested = std::chrono::steady_clock::now();
	auto par_nested_ans = par_nested(m);
	const auto end_par_nested = std::chrono::steady_clock::now();
	const auto elapsed_time_seq =
		std::chrono::duration_cast<std::chrono::microseconds>(end_seq - start_seq);
	std::cout << "Seq ans: " << seq_ans << '\n';
	std::cout << "Seq time: " << elapsed_time_seq.count() << " ms\n";
	const auto elapsed_time_par =
		std::chrono::duration_cast<std::chrono::microseconds>(end_par - start_par);
	std::cout << "Par ans: " << par_ans << '\n';
	std::cout << "Par time: " << elapsed_time_par.count() << " ms\n";
	const auto elapsed_time_par_nested =
		std::chrono::duration_cast<std::chrono::microseconds>(
			end_par_nested - start_par_nested);
	std::cout << "Par nested ans: " << par_nested_ans << '\n';
	std::cout << "Par nested time: " << elapsed_time_par_nested.count() << " 
		ms\n";
		return 0;
}