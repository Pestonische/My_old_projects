const dom = (function () {

    var formId = "";

    const tenantFrom = {
        tenantId: {
            label: 'id жильца',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите id жильца',
            name: 'tenantId',
            minValue: '1',
            step: '1',
            id: 'tenantId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };
	const workerFrom = {
        workerId: {
            label: 'id рабочего',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите id рабочего',
            name: 'workerId',
            minValue: '1',
            step: '1',
            id: 'workerId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };
    const taskFrom = {
        date: {
            label: 'id задания',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите id задания',
            name: 'taskId',
            minValue: '1',
            step: '1',
            id: 'taskId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    

    function buildForm(form, type) {
        var array;
        switch (type) {
            case 'tenantForm':
                array = tenantFrom;
                break;
            case 'workerForm':
                array = workerFrom;
                break;
            case 'taskForm':
                array = taskFrom;
                break;
            
        }

        for(const prop in array) {
            switch (array[prop].type) {
                default:
                    const formDiv = document.createElement('div');
                    formDiv.setAttribute('class', 'form-group');

                    const label = document.createElement('label');
                    label.innerHTML = array[prop].label;
                    formDiv.appendChild(label);

                    const input = document.createElement('input');
                    input.setAttribute('type', array[prop].type);
                    input.setAttribute('class', array[prop].class);
                    input.setAttribute('placeholder', array[prop].placeholder);
                    input.setAttribute('name', array[prop].name);
                    input.setAttribute('min', array[prop].minValue);
                    input.setAttribute('step', array[prop].step);
                    input.setAttribute("id", array[prop].id);
                    input.required = true;
                    formDiv.appendChild(input);

                    form.appendChild(formDiv);
                    break;
                case "submit":
                    const submit = document.createElement('input');
                    submit.setAttribute('type', array[prop].type);
                    submit.setAttribute('class', array[prop].class);
                    submit.value = array[prop].value;

                    form.appendChild(submit);
                    form.onSubmit = onSubmit();
                    break;
            }
        }
    }

    function initPage() {

        const tenantForm = document.getElementById('tenant-form');
        if (tenantForm != null) {
            buildForm(tenantForm, 'tenantForm');
            console.log('tenantForm');
            formId = 'tenant-form';
            return
        }

        const workerForm = document.getElementById('worker-form');
        if (workerForm != null) {
            buildForm(workerForm, 'workerForm');
            console.log('workerForm');
            formId = 'worker-form';
            return
        }

        const taskForm = document.getElementById('task-form');
        if (taskForm != null) {
            buildForm(taskForm, 'taskForm');
            console.log('taskForm');
            formId = 'task-form';
            return
        }

    }

    function onSubmit() {

    }

    return {
        initPage,
        onSubmit
    }

}());

dom.initPage();