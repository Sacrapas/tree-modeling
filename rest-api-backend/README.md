# Rest API for Tree Editor
host: `18.184.149.71:8080`

## Short API Listing
```
# Users
GET     /users                     get all users
GET     /{username}/trees          get user's trees ids
GET     /{username}/comments       get user's comments

# Trees
GET     /trees                     get all trees
GET     /trees/{tree_id}           get one tree
GET     /trees/{tree_id}/comments  get tree's comments
POST    /trees                     create new tree
PATCH   /trees/{tree_id}           update tree
DELETE  /trees/{tree_id}           delete tree

# Comments
POST    /comments                  create new comment
PATCH   /comments/{comment_id}     update comment
DELETE  /comments/{comment_id}     delete comment
```

## Users

----------------------------------------------------------------

**`GET:`** `/users` get all users
<details>
<summary>response example</summary>
<pre>
[
    { "id": 1, "username": "vasek"  },
    { "id": 2, "username": "sundar" },
    { "id": 3, "username": "jared"  },
    { "id": 4, "username": "richard"}
]
</pre>
</details>

----------------------------------------------------------------

**`GET:`** `/{username}/trees` get user's trees ids
<details>
<summary>response example</summary>
<pre>
[5, 6, 9, 18]
</pre>
</details>

----------------------------------------------------------------

**`GET:`** `/{username}/comments` get user's comments
<details>
<summary>response example</summary>
<pre>
[
    {
        "id"        : 11,
        "author"    : "vasek",
        "tree_id"   : 9,
        "tree_title": "tree_1",
        "text"      : "this is my first tree"
    },
    {
        "id"        : 14,
        "author"    : "vasek",
        "tree_id"   : 13,
        "tree_title": "tree_1",
        "text"      : "cool tree, man!"
    },
    {
        "id"        : 16,
        "author"    : "vasek",
        "tree_id"   : 15,
        "tree_title": "tree_1",
        "text"      : "waiting for update"
    }
]
</pre>
</details>

----------------------------------------------------------------

## Trees

----------------------------------------------------------------

**`GET:`** `/trees` get all trees (only metadata, tree-value is `null`)
<details>
<summary>response example</summary>
<pre>
[
    {
        "id"      : 5,
        "username": "vasek",
        "title"   : "tree_1",
        "comments": 0,
        "value"   : null
    },
    {
        "id"      : 6,
        "username": "vasek",
        "title"   : "tree_1",
        "comments": 0,
        "value"   : null
    },
    {
        "id"      : 7,
        "username": "sundar",
        "title"   : "tree_1",
        "comments": 0,
        "value"   : null
    },
    {
        "id"      : 8,
        "username": "jared",
        "title"   : "tree_1",
        "comments": 0,
        "value"   : null
    },
    {
        "id"      : 9,
        "username": "vasek",
        "title"   : "tree_1",
        "comments": 3,
        "value"   : null
    },
    {
        "id"      : 13,
        "username": "sundar",
        "title"   : "tree_1",
        "comments": 1,
        "value"   : null
    },
    {
        "id"      : 15,
        "username": "jared",
        "title"   : "tree_1",
        "comments": 2,
        "value"   : null
    },
    {
        "id"      : 18,
        "username": "vasek",
        "title"   : "tree_1",
        "comments": 0,
        "value"   : null
    }
]
</pre>
</details>

----------------------------------------------------------------

**`GET:`** `/trees/{tree_id}` get one tree (including tree value)
<details>
<summary>response example</summary>
<pre>
{
    "id": 5,
    "username": "vasek",
    "title": "tree_1",
    "comments": 0,
    "value": "{\"key\": 1}"
}
</pre>
</details>


----------------------------------------------------------------

**`GET:`** `/trees/{tree_id}/comments` get tree's comments
<details>
<summary>response example</summary>
<pre>
[
    {
        "id"        : 16,
        "author"    : "vasek",
        "tree_id"   : 15,
        "tree_title": "tree_1",
        "text"      : "waiting for update"
    },
    {
        "id"        : 17,
        "author"    : "sundar",
        "tree_id"   : 15,
        "tree_title": "tree_1",
        "text"      : "this is bad"
    }
]
</pre>
</details>

----------------------------------------------------------------

**`POST:`** `/trees` create new tree

use `JSON.stringify()` to convert js-object to string

<details>
<summary>request body example</summary>
<pre>
{
    "title": "my first tree",
    "value": "here is your json as a string"
}
</pre>
</details>

---

**`PATCH:`** `/trees/{tree_id}` update tree

use `JSON.stringify()` to convert js-object to string

<details>
<summary>request body example</summary>
<pre>
{
    "title": "my new title",
    "value": "my updated tree-value"
}
</pre>
</details>

----------------------------------------------------------------

**`DELETE:`** `/trees/{tree_id}` delete tree

----------------------------------------------------------------

## Comments

----------------------------------------------------------------

**`POST:`** `/comments` create new comment

<details>
<summary>request body example</summary>
<pre>
{
    "tree_id": 18,
    "text"   : "just another useless comment"
}
</pre>
</details>


----------------------------------------------------------------

**`PATCH:`** `/comments/{comment_id}` update comment

<details>
<summary>request body example</summary>
<pre>
{ "text": "some updated comment text" }
</pre>
</details>

----------------------------------------------------------------

**`DELETE:`** `/comments/{comment_id}` delete comment

----------------------------------------------------------------
