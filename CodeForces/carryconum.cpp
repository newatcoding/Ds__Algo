#include<bits/stdc++.h>
#include<map>
 
#include<iterator>
#include<vector>
#include <algorithm>
using namespace std;
 
#define ll long long int
#define mod 1e9 +7
#define ff first
#define ss second
#define vi vector<int>
#define vvi vector<vi>
#define pii pair<int,int>
#define vii vector<pii>
#define rep(i,a,b)  for(int i=a;i<b;i++)
#define pb  push_back
 
const int N = 1e5+2;
 
bool PerfectSquare(ll x)
{
 
    if (x >= 0) {
 
        ll sr = sqrt(x);
 
 
        return (sr * sr == x);
    }
 
    return false;
}
 
int main(){
 
ll t;
cin >>t;
while(t--){
    ll n;
    cin >>n;
    long double ans = sqrt(n);
 if(n < 10){
     cout << n-1<<endl;
 }else if(PerfectSquare(n)){
     cout << ans -1<<endl;
 }
    else if(n%2 == 0){
        cout << ceil(ans)<<endl;
    }else{
        cout <<floor(ans)<<endl;
    }
}
 
}