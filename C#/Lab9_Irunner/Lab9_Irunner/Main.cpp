#include <iostream>
#include <fstream> 
#include <vector>

using namespace std;

class BinarySearchTree {
public:
    long long MSL;
    long long IS_SECOND;
    class Node {
    public:
        Node* parent;
        Node* left;
        Node* right;
        long long data;
        long long height;
        long long lengthHalfRoute;
        long long numOfLeaves;
        long long diffWay1;
        long long diffWay2;

        Node(long long data) {
            this->numOfLeaves = 0;
            this->lengthHalfRoute = 0;
            this->diffWay1 = 0;
            this->diffWay2 = 0;
            this->height = 0;
            this->data = data;
            this->left = NULL;
            this->right = NULL;
            this->parent = NULL;
        }

        void insertNode(long long insert) {
            if (this->data > insert && this->left == NULL) {
                this->left = new Node(insert);
                this->left->parent = this;
            }
            else if (this->data > insert && this->left != NULL) {
                this->left->insertNode(insert);
            }
            else if (this->data < insert && this->right == NULL) {
                this->right = new Node(insert);
                this->right->parent = this;
            }
            else if (this->data < insert&& this->right != NULL) {
                this->right->insertNode(insert);
            }
        }

        long long max(long long x, long long y) {
            return x > y ? x : y;
        }

        void reversedLeftWithSetHeight(BinarySearchTree* binarySearchTree) {
            long long leftHeight = 0;
            long long rightHeight = 0;
            long long maxHeight;

            if (this->left != NULL) {
                this->left->reversedLeftWithSetHeight(binarySearchTree);
            }

            if (this->right != NULL) {
                this->right->reversedLeftWithSetHeight(binarySearchTree);
            }

            if (this->isNodeLeave()) {
                this->height = 0;
                this->numOfLeaves = 1;
                this->lengthHalfRoute = 0;
                return;
            }
            else if (this->isNodeWithOneUnderTree()) {
                if (this->left != NULL) {
                    this->numOfLeaves = this->left->numOfLeaves;
                    this->height = this->left->height + 1;
                    this->lengthHalfRoute = this->left->height + 1;
                    leftHeight = this->left->height;
                }
                else {
                    this->numOfLeaves = this->right->numOfLeaves;
                    this->height = this->right->height + 1;
                    this->lengthHalfRoute = this->right->height + 1;
                    rightHeight = this->right->height;
                }
            }
            else {
                if (this->left->numOfLeaves == this->right->numOfLeaves) {
                    this->numOfLeaves = 2 * this->left->numOfLeaves;
                }
                else if (this->left->numOfLeaves > this->right->numOfLeaves) {
                    this->numOfLeaves = this->left->numOfLeaves;
                }
                else {
                    this->numOfLeaves = this->right->numOfLeaves;
                }
                leftHeight = this->left->height;
                rightHeight = this->right->height;
            }
            maxHeight = max(leftHeight, rightHeight);
            this->height = ++maxHeight;
            this->lengthHalfRoute = leftHeight + rightHeight + this->numOfSons();
            binarySearchTree->MSL = max(binarySearchTree->MSL, this->lengthHalfRoute);
        }

        void determineNumOfDifferent(BinarySearchTree* binarySearchTree) {

            if (this->lengthHalfRoute == binarySearchTree->MSL) {
                if (this->isNodeWithOneUnderTree()) {
                    if (this->left != NULL) {
                        this->diffWay1 = this->left->numOfLeaves;
                    }
                    else {
                        this->diffWay1 = this->right->numOfLeaves;
                    }
                }
                else {
                    this->diffWay1 = this->left->numOfLeaves * this->right->numOfLeaves;
                }
            }
            else {
                this->diffWay1 = 0;
            }
            if (this->isNodeWithOneUnderTree()) {
                if (this->left != NULL) {
                    this->left->diffWay2 = this->diffWay2 + this->diffWay1;
                    this->left->determineNumOfDifferent(binarySearchTree);
                }
                else {
                    this->right->diffWay2 = this->diffWay2 + this->diffWay1;
                    this->right->determineNumOfDifferent(binarySearchTree);
                }
            }
            else if (!this->isNodeLeave()) {
                if (this->left->height > this->right->height) {
                    this->left->diffWay2 = this->diffWay2 + this->diffWay1;
                    this->right->diffWay2 = this->diffWay1;
                }
                else if (this->left->height < this->right->height) {
                    this->right->diffWay2 = this->diffWay2 + this->diffWay1;
                    this->left->diffWay2 = this->diffWay1;
                }
                else {
                    this->left->diffWay2 = this->diffWay1 +
                        this->left->numOfLeaves * this->diffWay2 / this->numOfLeaves;
                    this->right->diffWay2 = this->diffWay1 +
                        this->right->numOfLeaves * this->diffWay2 / this->numOfLeaves;
                }
                this->left->determineNumOfDifferent(binarySearchTree);
                this->right->determineNumOfDifferent(binarySearchTree);
            }
        }

        void findDeleteNode(BinarySearchTree* binarySearchTree) {
            if (this->left != NULL) {
                this->left->findDeleteNode(binarySearchTree);
            }

            if (this->isInRoute()) {
                if (binarySearchTree->IS_SECOND == 1) {
                    this->delet(this->data);
                    binarySearchTree->IS_SECOND++;
                    return;
                }
                else {
                    binarySearchTree->IS_SECOND++;
                }
            }

            if (this->right != NULL) {
                this->right->findDeleteNode(binarySearchTree);
            }
        }

        bool isInRoute() {
            return this->diffWay2 + this->diffWay1 > 0 ? true : false;
        }

        void straightLeftDetour(ofstream& out) {                
            if (this != NULL) {
                out << this->data << "\n";
                if (this->left != NULL) {
                    this->left->straightLeftDetour(out);
                }
                if (this->right != NULL) {
                    this->right->straightLeftDetour(out);
                }
            }
        }

        long long numOfSons() {
            return this->isNodeLeave() ? 0 :
                this->isNodeWithOneUnderTree() ? 1 : 2;
        }

        bool isNodeWithOneUnderTree() {
            return (this->left == NULL && this->right != NULL) ? true :
                (this->left != NULL && this->right == NULL) ? true : false;
        }

        bool isNodeLeave() {
            return (this->left == NULL && this->right == NULL);
        }

        Node* deleteLeave() {
            if (this == this->parent->right) {
                this->parent->right = NULL;
            }
            else if (this == this->parent->left) {
                this->parent->left = NULL;
            }

            return this;
        }

        Node* deleteNodeWithOneUnderTree() {
            if (this->left != NULL) {
                if (this->parent->left == this) {
                    this->parent->left = this->left;
                    this->left->parent = this->parent;
                }
                else if (this->parent->right == this) {
                    this->parent->right = this->left;
                    this->left->parent = this->parent;
                }
            }
            else if (this->right != NULL) {
                if (this->parent->left == this) {
                    this->parent->left = this->right;
                    this->right->parent = this->parent;
                }
                else if (this->parent->right == this) {
                    this->parent->right = this->right;
                    this->right->parent = this->parent;
                }
            }

            return this;
        }

        Node* deleteNodeWithTwoUnderTree() {
            if (this->isNodeLeave()) {
                return this->deleteLeave();
            }
            else if (this->isNodeWithOneUnderTree() && this->right != NULL) {
                return this->deleteNodeWithOneUnderTree();
            }
            else {
                return this->left->deleteNodeWithTwoUnderTree();
            }
        }

        void delet(long long delet) {
            if (this->data == delet) {
                if (this->isNodeLeave()) {

                    this->deleteLeave();

                }
                else if (this->isNodeWithOneUnderTree()) {

                    this->deleteNodeWithOneUnderTree();

                }
                else {

                    Node* newInsert = this->right->deleteNodeWithTwoUnderTree();
                    this->data = newInsert->data;
                }
            }
            else if (this->data > delet && this->left != NULL) {
                this->left->delet(delet);
            }
            else if (this->data < delet && this->right != NULL) {
                this->right->delet(delet);
            }
        }

    };
        

    Node* root;

    BinarySearchTree(){

        this->root = NULL;
        this->MSL = 0;
        this->IS_SECOND = 0;
    }

    void insert(long long insert) {

        if (this->root == NULL) {
            this->root = new Node(insert);
        }
        else {
            this->root->insertNode(insert);
        }

    }

    void straightLeftDetour(ofstream& out) {

        if (this->root != NULL) {
            this->root->straightLeftDetour(out);
        }

    }

    void determineNumOfDifferent(BinarySearchTree* binarySearchTree) {

        this->root->diffWay2 = 0;

        if (this->root->lengthHalfRoute == binarySearchTree->MSL) {
            if (this->root->isNodeWithOneUnderTree()) {
                if (this->root->left != NULL) {
                    this->root->diffWay1 = this->root->left->numOfLeaves;
                    this->root->left->diffWay2 = this->root->diffWay2 + this->root->diffWay1;
                }
                else {
                    this->root->diffWay1 = this->root->right->numOfLeaves;
                    this->root->right->diffWay2 = this->root->diffWay2 + this->root->diffWay1;
                }
            }
            else {
                this->root->diffWay1 = this->root->left->numOfLeaves * this->root->right->numOfLeaves;

                if (this->root->left->height > this->root->right->height) {
                    this->root->left->diffWay2 = this->root->diffWay2 + this->root->diffWay1;
                    this->root->right->diffWay2 = this->root->diffWay1;
                }
                else if (this->root->left->height < this->root->right->height) {
                    this->root->right->diffWay2 = this->root->diffWay2 + this->root->diffWay1;
                    this->root->left->diffWay2 = this->root->diffWay1;
                }
                else {
                    this->root->left->diffWay2 = this->root->diffWay1 +
                        this->root->left->numOfLeaves * this->root->diffWay2 / this->root->numOfLeaves;
                    this->root->right->diffWay2 = this->root->diffWay1 +
                        this->root->right->numOfLeaves * this->root->diffWay2 / this->root->numOfLeaves;
                }
            }
        }
        else {
            this->root->diffWay1 = 0;
        }

        if (this->root->left != NULL) {
            this->root->left->determineNumOfDifferent(binarySearchTree);
        }

        if (this->root->right != NULL) {
            this->root->right->determineNumOfDifferent(binarySearchTree);
        }
    }

    void reversedLeftWithSetHeight(BinarySearchTree* binarySearchTree) {
        if (this->root != NULL) {
            this->root->reversedLeftWithSetHeight(binarySearchTree);
        }
    }

    void delet(long long delet) {
        if (this->root == NULL) {
            return;
        }
        else if (this->root->isNodeLeave()) {
            this->root = NULL;
            return;
        }
        else if (this->root->data == delet
            && this->root->isNodeWithOneUnderTree()) {
            if (this->root->right != NULL) {
                this->root = this->root->right;
                return;
            }
            else {
                this->root = this->root->left;
                return;
            }
        }
        else {
            this->root->delet(delet);
        }
    }

    void delet(BinarySearchTree* binarySearchTree) {
        this->root->findDeleteNode(binarySearchTree);
    }
};

int main()
{
    BinarySearchTree* tree = new BinarySearchTree();
    ifstream in;
    ofstream out;
    in.open("in.txt");
    out.open("out.txt");
    long long key;
    while (!in.eof()) {
        in >> key;
        tree->insert(key);
    }
    tree->reversedLeftWithSetHeight(tree);
    tree->determineNumOfDifferent(tree);
    tree->delet(tree);
    tree->straightLeftDetour(out);
    out.close();
    in.close();          
}