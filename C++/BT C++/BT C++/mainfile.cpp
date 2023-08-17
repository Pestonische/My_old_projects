#include <iostream>
#include <vector>
#include <fstream>

using namespace std;

struct  BT
{
    int info;
    BT* lSon;
    BT* rSon;
    BT* father;
};

vector<BT*> mas;
BT* root = NULL;

void Insert(int x, BT* b, char s)
{
    BT* r = new BT();
    r->info = x;
    if (s == 'L') {
        b->lSon = r;
        b->lSon->father = b;
        mas.push_back(b->lSon);
    }
    else {
        b->rSon = r;
        b->rSon->father = b;
        mas.push_back(b->rSon);
    }
}
bool Insert1(int x)
{
    BT* r;
    if (root == nullptr)
    {
        r = new BT();
        r->info = x;
        root = r;
        return true;
    }    
    return false;
}

bool checking_right_tree(BT* _root, BT* _root_2)
{
    if (_root_2 == nullptr)
    {
        return false;
    }
    if (_root != _root_2)
    {
        if (!checking_right_tree(_root, _root_2->lSon) && !checking_right_tree(_root, _root_2->rSon))
        {
            return false;
        }
    }
    else 
    {
        return true;
    }
    return true;
}

BT* pp = 0;

bool PreOrderTraversal(BT* _root)
{    
    if (_root->lSon != nullptr) 
    {
        if (!PreOrderTraversal(_root->lSon)) 
        {
            return false;
        }
    }
    if ((pp == nullptr) || (pp->info < _root->info))
    {
        pp = _root;
    }
    else if (pp->info > _root->info)
    {
        return false;
    }
    else 
    {
        if (!checking_right_tree(_root, pp->rSon))
        {
            return false;
        }
        else 
        {
            pp = _root;
        }
    }
    if (_root->rSon != nullptr) 
    {
        if (!PreOrderTraversal(_root->rSon)) 
        {
            return false;
        }
    }
    return true;
}


bool PreOrderTravesal_()
{
    return PreOrderTraversal(root);
}


int main()
{
    ifstream in;
    ofstream out;
    
    in.open("bst.in");
    out.open("bst.out");
    int n = 0, m = 0;
    
     in >> n;
     in >> m;

    if (Insert1(m))
    {
        mas.push_back(root);
    }
    int first = 0, second = 0;
    char s = ' ';

    for (int i = 0; i < n - 1; i++)
    {
        in >> first;
        in >> second;
        in >> s;
        
        Insert(first, mas[second - 1], s);
    }

    in.close();
    if (PreOrderTravesal_())
    {
        out<<"YES";
    }
    else
    {
        out<<"NO";
    }
    out.close();
}
