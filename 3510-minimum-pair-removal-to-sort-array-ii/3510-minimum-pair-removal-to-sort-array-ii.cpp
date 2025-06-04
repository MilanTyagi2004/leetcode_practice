class Solution {
public:
    int minimumPairRemoval(vector<int>& nums) {
        map<int, long long> mpp;
        for (int i = 0; i < nums.size(); ++i) mpp[i] = nums[i];

        priority_queue<pair<long long, int>> pq;
        int sorted = 0;
        for (int i = 1; i < nums.size(); ++i) {
            pq.push({-(nums[i - 1] + nums[i]), -(i - 1)});
            if (nums[i] >= nums[i - 1]) sorted++;
        }
        if (sorted == nums.size() - 1) return 0;

        while (mpp.size() >= 2) {
            int left = -1, right = -1;
            while (true) {
                long long sum = -pq.top().first;
                left = -pq.top().second;
                pq.pop();
                if (mpp.count(left) && prev(mpp.end())->first > left) {
                    right = mpp.lower_bound(left + 1)->first;
                    if (mpp[left] + mpp[right] == sum) break;
                }
            }

            int pre = (mpp.begin()->first < left) ? prev(mpp.lower_bound(left))->first : -1;
            int next = (prev(mpp.end())->first > right) ? mpp.lower_bound(right + 1)->first : -1;
            if (mpp[left] <= mpp[right]) sorted--;
            if (pre != -1 && mpp[pre] <= mpp[left]) sorted--;
            if (next != -1 && mpp[right] <= mpp[next]) sorted--;
            mpp[left] += mpp[right];
            mpp.erase(right);
            if (pre != -1) {
                pq.push({-(mpp[pre] + mpp[left]), -pre});
                if (mpp[pre] <= mpp[left]) sorted++;
            }
            if (next != -1) {
                pq.push({-(mpp[left] + mpp[next]), -left});
                if (mpp[left] <= mpp[next]) sorted++;
            }
            if (sorted == mpp.size() - 1)
                return nums.size() - mpp.size();
        }
        return nums.size();
    }
};