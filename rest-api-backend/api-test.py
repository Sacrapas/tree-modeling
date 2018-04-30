import requests

host = 'http://localhost:8080'

body = {
    'tree_id': 18,
    'text': '777-777-8-666'
}

body2 = {
    'text': '0000000-00000'
}

# r = requests.post(host + '/comments', json=body)
# r = requests.patch(host + '/comments/19', json=body2)
# r = requests.delete(host + '/comments/19')
# print(r.status_code)
# print(r.text)
# print(r.json())



body = {
    "title": "my first tree",
    "value": "777here is your j---son as a string"
}

# r = requests.post(host + '/trees', json=body)
# r = requests.patch(host + '/trees/19', json=body)
r = requests.delete(host + '/trees/19', json=body)
